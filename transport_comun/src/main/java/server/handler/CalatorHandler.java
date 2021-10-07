package server.handler;

import server.Model.LiniiTransport;
import server.Model.LiniiTransportPersistenta;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class CalatorHandler {
    LiniiTransportPersistenta l=new LiniiTransportPersistenta();
    public static Iterator<Integer> range(int start, int end) {
        return new Iterator<Integer>() {
            private int index = start;

            @Override
            public boolean hasNext() {
                return index < end;
            }

            @Override
            public Integer next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return index++;
            }
        };
    }

public CalatorHandler(){}
    public String afisareLinii() throws SQLException {
    ArrayList<LiniiTransport> linii=(ArrayList<LiniiTransport>) l.viewLinii();
    String linii2="";
        Iterator<Integer> iterator = range(0, linii.size());
        while (iterator.hasNext()) {
            linii2+=(linii.get(iterator.next())+"\n");
        }
        return linii2;
    }
    public String searchLinie(int numarLinie) throws SQLException {
        LiniiTransport linie=l.viewLinie(numarLinie);
        String a=linie.getNrLinie()+";"+linie.getNumeStatie();
        return a;
    }
}
