import java.lang.reflect.Array;
import java.util.Random;

public class MagicBox<T> {
    private final T[] items;
    private int itemCount = 0;
    private final Random random;

    public MagicBox(int numberOfItems) {
        this.items = (T[]) new Object[numberOfItems];
        random = new Random();
    }

    public MagicBox(Class<T[]> cls, int numberOfItems) {
        this.items = cls.cast(Array.newInstance(cls.getComponentType(), numberOfItems));
        random = new Random();
    }

    public boolean add(T item) {
        if (items.length > itemCount) {
            items[itemCount++] = item;
            return true;
        }
        return false;
    }

    public T pick() throws RuntimeException {
        if (itemCount < items.length) {
            throw new RuntimeException(String.format("Коробочка не полна(, свободно слотов: %3d", items.length - itemCount));
        }
        return items[random.nextInt(itemCount - 1)];
    }
}
