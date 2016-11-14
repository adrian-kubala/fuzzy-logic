package pl.fuzzy;

import pl.fuzzy.Model.Bath;
import pl.fuzzy.Model.Boiler;
import pl.fuzzy.Model.Shower;
import pl.fuzzy.Model.Sink;
import pl.fuzzy.Model.UsingWaterObject;


public class FuzzyHeat {
    public int ambientTemperature;
    
    public Boiler boiler;
    
    private Bath bath;
    private Sink sink;
    private Shower shower;
    
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
        
        shower = new Shower(40);
        bath = new Bath(70);
        sink = new Sink(8);
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
