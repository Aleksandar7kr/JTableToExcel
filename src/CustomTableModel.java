import entity.Location;
import entity.Person;

import javax.swing.table.AbstractTableModel;
import java.util.*;

public class CustomTableModel extends AbstractTableModel {
    private static final int COL_COUNT = 2;
    private static final Map<Integer, String> COLUMN_NAMES = new HashMap<>();
    private static final Map<Integer, Class<?>> COLUMN_TYPES = new HashMap<>();

    static {
        COLUMN_NAMES.put(0, "Person");
        COLUMN_NAMES.put(1, "Location");

        COLUMN_TYPES.put(0, Person.class);
        COLUMN_TYPES.put(1, Location.class);
    }

    private final List<Pair<Person, Location>> data = new ArrayList<>();

    public CustomTableModel(List<Pair<Person, Location>> initialData) {
        data.addAll(initialData);
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return COL_COUNT;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return COLUMN_NAMES.get(columnIndex);
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return COLUMN_TYPES.get(columnIndex);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Pair<Person, Location> pair = data.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return pair.getFirst();
            case 1:
                return pair.getSecond();
            default:
                throw new IllegalStateException("Unable to find data in column " + columnIndex);
        }
    }
}
