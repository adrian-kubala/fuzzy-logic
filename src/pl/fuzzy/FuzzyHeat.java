package pl.fuzzy;


public class FuzzyHeat {
    public int to, tb, heat;
    public double max_capacity;
    public String[][] use; 
    
    /*
    heat
    1-brak ogrzewania
    2-nieco ogniewaj
    3-ogrzewaj
    4-bardzo ogrzewaj
    
    to
    1-bardzo wysoka
    2-wysoka
    3-średnia
    4-niska
    5-bardzo niska
    
    tb
    1-bardzo wysoka
    2-wysoka
    3-średnia
    4-niska
    5-bardzo niska
    
    */
    public FuzzyHeat(){
        init();
        calcHeat();
    }
    public void init(){
        max_capacity = 120;
        use[0][0] = "shower";
        use[0][1] = "40";
        use[1][0] = "bath";        
        use[1][1] = "70";
        use[2][0] = "sink";
        use[2][1] = "8";
    }
    public int calcHeat(){
        if(to == 1 && tb == 1)heat=1;
        if(to == 1 && tb == 2)heat=1;
        if(to == 1 && tb == 3)heat=1;
        if(to == 1 && tb == 4)heat=1;
        if(to == 1 && tb == 5)heat=1;
        if(to == 2 && tb == 1)heat=1;
        if(to == 2 && tb == 2)heat=2;
        if(to == 2 && tb == 3)heat=2;
        if(to == 2 && tb == 4)heat=3;
        if(to == 2 && tb == 5)heat=3;
        if(to == 3 && tb == 1)heat=2;
        if(to == 3 && tb == 2)heat=2;
        if(to == 3 && tb == 3)heat=3;
        if(to == 3 && tb == 4)heat=4;
        if(to == 3 && tb == 5)heat=4;
        if(to == 4 && tb == 1)heat=3;
        if(to == 4 && tb == 2)heat=3;
        if(to == 4 && tb == 3)heat=4;
        if(to == 4 && tb == 4)heat=4;
        if(to == 4 && tb == 5)heat=4;
        if(to == 5 && tb == 1)heat=4;
        if(to == 5 && tb == 2)heat=4;
        if(to == 5 && tb == 3)heat=4;
        if(to == 5 && tb == 4)heat=4;
        if(to == 5 && tb == 5)heat=4;
        return heat;
    }
}
