package client.Raport;

public class ReportConcreteCreator{

    public static Report factoryMethod(String type)
    {
        if (type.equals("csv"))
        {

            return new ReportCSV();
        }if (type.equals("json"))
        {

            return new ReportJSON();
        }

        if (type.equals("html"))
        {

            return new ReportHTML();
        }
        if (type.equals("txt"))
        {
            return new ReportTXT();
        }

        return null;
    }



}
