package presentation;

//import com.sun.deploy.panel.JreTableModel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.lang.reflect.Field;
import java.util.List;

public class Table {

    public static JTable createTable(List<Object> list)
    {
        int nrCols = list.get(0).getClass().getDeclaredFields().length;
        int nrRows = list.size();


        String[] columnNames = new String[nrCols];
        Object[][] matrix = new Object[nrRows][nrCols];
        int i = 0;
        int j = 0;

        for(Field field: list.get(0).getClass().getDeclaredFields())
        {
            columnNames[i] = field.getName();
            i++;
        }

        i=0;
        for( Object object : list) {
            for (Field filed : object.getClass().getDeclaredFields()) {
                filed.setAccessible(true);
                try {
                        matrix[i][j] = filed.get(object);
                        System.out.println(i +" " + j);
                        j++;
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }

            }
         i++;
         j=0;
        }
        
        JTable table = new JTable(matrix, columnNames);

        return table;

    }

}