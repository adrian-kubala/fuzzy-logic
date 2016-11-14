package pl.fuzzy;

import pl.fuzzy.Model.Boiler;


public class FuzzyHeat {
    public Boiler boiler;
    public int ambientTemperature;
    public String[][] use;
    
    /*
    boiler.temperature
    1-brak ogrzewania
    2-nieco ogniewaj
    3-ogrzewaj
    4-bardzo ogrzewaj
    
    ambientTemperature
    1-bardzo wysoka
    2-wysoka
    3-średnia
    4-niska
    5-bardzo niska
    
    boiler.temperature
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
        boiler.waterCapacity = 120.0;
        use[0][0] = "shower";
        use[0][1] = "40";
        use[1][0] = "bath";        
        use[1][1] = "70";
        use[2][0] = "sink";
        use[2][1] = "8";
    }
    
    public int calcHeat(){
        if(ambientTemperature == 1 && boiler.temperature == 1)boiler.temperature=1;
        if(ambientTemperature == 1 && boiler.temperature == 2)boiler.temperature=1;
        if(ambientTemperature == 1 && boiler.temperature == 3)boiler.temperature=1;
        if(ambientTemperature == 1 && boiler.temperature == 4)boiler.temperature=1;
        if(ambientTemperature == 1 && boiler.temperature == 5)boiler.temperature=1;
        if(ambientTemperature == 2 && boiler.temperature == 1)boiler.temperature=1;
        if(ambientTemperature == 2 && boiler.temperature == 2)boiler.temperature=2;
        if(ambientTemperature == 2 && boiler.temperature == 3)boiler.temperature=2;
        if(ambientTemperature == 2 && boiler.temperature == 4)boiler.temperature=3;
        if(ambientTemperature == 2 && boiler.temperature == 5)boiler.temperature=3;
        if(ambientTemperature == 3 && boiler.temperature == 1)boiler.temperature=2;
        if(ambientTemperature == 3 && boiler.temperature == 2)boiler.temperature=2;
        if(ambientTemperature == 3 && boiler.temperature == 3)boiler.temperature=3;
        if(ambientTemperature == 3 && boiler.temperature == 4)boiler.temperature=4;
        if(ambientTemperature == 3 && boiler.temperature == 5)boiler.temperature=4;
        if(ambientTemperature == 4 && boiler.temperature == 1)boiler.temperature=3;
        if(ambientTemperature == 4 && boiler.temperature == 2)boiler.temperature=3;
        if(ambientTemperature == 4 && boiler.temperature == 3)boiler.temperature=4;
        if(ambientTemperature == 4 && boiler.temperature == 4)boiler.temperature=4;
        if(ambientTemperature == 4 && boiler.temperature == 5)boiler.temperature=4;
        if(ambientTemperature == 5 && boiler.temperature == 1)boiler.temperature=4;
        if(ambientTemperature == 5 && boiler.temperature == 2)boiler.temperature=4;
        if(ambientTemperature == 5 && boiler.temperature == 3)boiler.temperature=4;
        if(ambientTemperature == 5 && boiler.temperature == 4)boiler.temperature=4;
        if(ambientTemperature == 5 && boiler.temperature == 5)boiler.temperature=4;
        return boiler.temperature;
    }
}
