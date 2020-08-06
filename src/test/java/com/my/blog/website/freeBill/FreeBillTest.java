package com.my.blog.website.freeBill;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class FreeBillTest {

    public static void main(String[] args) {

    }

    private static List<BigDecimal> FREE_BILL_INIT = Arrays.asList(BigDecimal.valueOf(150),BigDecimal.valueOf(310),
            BigDecimal.valueOf(500),BigDecimal.valueOf(700),BigDecimal.valueOf(1000));

    private static BigDecimal  FREE_BILL_STEP_AMOUNT = BigDecimal.valueOf(100);

    private static BigDecimal FREE_BILL_RANGE_AMOUNT = BigDecimal.valueOf(70);

    private static int STEP_SHOW_NUM = 5;

    private static int BILL_STEP_STATE_YES = 1;

    private static int BILL_STEP_STATE_NO = 0;




    private List<FreeBillStepDetail> getStepDetailList(ShareFreeBillInfo billInfo){
        //已减金额未0不展示节点情况
        if(billInfo.getReducedPrice() == null ||billInfo.getReducedPrice().compareTo(BigDecimal.ZERO) <= 0){
            return null;
        }
        List<BigDecimal> productReduceStep = getStepAmountList(billInfo.getProductInstalmentAmount());
        List<BigDecimal> billInstalmentReduceStep = getStepAmountList(billInfo.getBillInstalmentAmount());
        List<BigDecimal> totalBillReduceStep = getStepAmountList(billInfo.getTotalBillAmount());
        int stepShowNum  = STEP_SHOW_NUM;
        List<BigDecimal> returnReduceStep;
        //int actNum = billInfo.getActNum();
        int actNum = 0;
        if(actNum < productReduceStep.size())
            returnReduceStep = productReduceStep;
        else if(actNum < billInstalmentReduceStep.size())
            returnReduceStep = billInstalmentReduceStep;
        else
            returnReduceStep = totalBillReduceStep;
        //节点个数>5个
        if(returnReduceStep.size() > stepShowNum){
            if(actNum<stepShowNum)
                returnReduceStep = FREE_BILL_INIT;
            else{
                //激活个数/显示个数
                int startNum = actNum-1/stepShowNum-1 * (stepShowNum-1);
                int endNum = startNum + stepShowNum > returnReduceStep.size()? returnReduceStep.size():startNum + stepShowNum;
                returnReduceStep = returnReduceStep.subList(startNum,endNum);
            }
        }

        List<FreeBillStepDetail> billStepDetailList = new ArrayList<>();
        returnReduceStep.forEach((step)->{
            FreeBillStepDetail stepDetail = new FreeBillStepDetail();
            if(step.compareTo(billInfo.getReducedPrice())<=0)
                stepDetail.setStepState(BILL_STEP_STATE_YES);
            else
                stepDetail.setStepState(BILL_STEP_STATE_NO);
            stepDetail.setStepReducePrice(step);
            billStepDetailList.add(stepDetail);
        });
        return billStepDetailList;
    }

    @Test
    public void teststep(){
        ShareFreeBillInfo billInfo =new ShareFreeBillInfo(BigDecimal.valueOf(4200),BigDecimal.valueOf(0),BigDecimal.valueOf(2000),BigDecimal.valueOf(4000));
        List<FreeBillStepDetail> result = getStepDetailListTest(billInfo);
        System.out.println(result);
    }

    private List<FreeBillStepDetail> getStepDetailListTest(ShareFreeBillInfo billInfo){
        //已减金额未0不展示节点情况
        if(billInfo.getReducedPrice() == null ||billInfo.getReducedPrice().compareTo(BigDecimal.ZERO) <= 0){
            return null;
        }
        List<List<BigDecimal>> allReduceStepList = Arrays.asList(
                getStepAmountList(billInfo.getProductInstalmentAmount()),
                getStepAmountList(billInfo.getBillInstalmentAmount()),
                getStepAmountList(billInfo.getTotalBillAmount())
        );
        int stepShowNum  = STEP_SHOW_NUM;
        int actNum = allReduceStepList.get(allReduceStepList.size()-1).indexOf(billInfo.getReducedPrice())+1;
        List<BigDecimal> returnReduceStep = allReduceStepList.stream().filter(info ->
                info.size()>actNum
            ).findFirst().orElse(allReduceStepList.get(allReduceStepList.size()-1));
        //节点个数>5个
        if(returnReduceStep.size() > stepShowNum){
            if(actNum<stepShowNum)
                returnReduceStep = FREE_BILL_INIT;
            else{
                //激活个数/显示个数
                int startNum = (actNum-1)/(stepShowNum-1) * (stepShowNum-1);
                int endNum = startNum + stepShowNum > returnReduceStep.size()? returnReduceStep.size():startNum + stepShowNum;
                returnReduceStep = returnReduceStep.subList(startNum,endNum);
            }
        }

        List<FreeBillStepDetail> billStepDetailList = returnReduceStep.stream().map(step->{
            FreeBillStepDetail stepDetail = new FreeBillStepDetail();
            if(step.compareTo(billInfo.getReducedPrice())<=0)
                stepDetail.setStepState(BILL_STEP_STATE_YES);
            else
                stepDetail.setStepState(BILL_STEP_STATE_NO);
            stepDetail.setStepReducePrice(step);
            return stepDetail;
        }).collect(Collectors.toList());

        return billStepDetailList;
    }

    @Test
    public void testamount(){
        List<BigDecimal> amountList = getStepAmountList(BigDecimal.valueOf(770));
        System.out.println(amountList);
    }

    /**
     * 获取免账单节点金额list
     * @param targetPrice
     * @return
     */
    private List<BigDecimal> getStepAmountList(BigDecimal targetPrice) {
        List<BigDecimal> resultStep = new ArrayList<>();
        List<BigDecimal> initStep = FREE_BILL_INIT;
        BigDecimal firstValue = initStep.get(0);
        BigDecimal lastValue = initStep.get(initStep.size()-1);
        BigDecimal stepAmount = FREE_BILL_STEP_AMOUNT;
        BigDecimal rangeAmount =FREE_BILL_RANGE_AMOUNT;
        if (targetPrice.compareTo(firstValue) <= 0 && targetPrice.compareTo(BigDecimal.ZERO)>0) {
            resultStep.add(targetPrice);
        } else if (targetPrice.compareTo(lastValue) >= 0) {
            resultStep.addAll(initStep);
            int extraNum = targetPrice.subtract(lastValue).divide(stepAmount).intValue();
            //求余数
            BigDecimal remain = targetPrice.subtract(lastValue).remainder(stepAmount);
            for (int i = 1; i < extraNum + 1; i++) {
                BigDecimal amount = lastValue.add(BigDecimal.valueOf(i).multiply(stepAmount));
                resultStep.add(amount);
            }
            if(remain.compareTo(rangeAmount)<0){
                resultStep.remove(resultStep.size()-1);
            }
            resultStep.add(targetPrice);
        }else if(targetPrice.compareTo(firstValue) > 0){
            resultStep = initStep.stream().filter(amount -> targetPrice.compareTo(amount)>=0).collect(Collectors.toList());
            BigDecimal reminder = targetPrice.subtract(resultStep.get(resultStep.size()-1));
            if(reminder.compareTo(rangeAmount)<0){
                resultStep.remove(resultStep.size()-1);
            }
            resultStep.add(targetPrice);

        }
        return resultStep;
    }


}
