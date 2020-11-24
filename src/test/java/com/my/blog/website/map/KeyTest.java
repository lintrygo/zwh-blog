package com.my.blog.website.map;


public class KeyTest {

    private Integer id;

    public Integer getId() {
        return id;
    }

    public KeyTest(Integer id) {
        this.id = id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


  public boolean equals(Object o) {
         if (o == null || !(o instanceof KeyTest))
          { return false; }
          else
           { return this.getId().equals(((KeyTest) o).getId());}
    }

        public int hashCode()
        { return id.hashCode(); }

}
