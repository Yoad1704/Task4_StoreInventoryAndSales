public class Product
{

    private int _id;
    private String _name;
    private double _price;
    private int _stock;
    private static int _nextId = 1000;

    public Product(String name, double price, int stock)
    {
        _id = _nextId;
        _nextId++; // like in previous project make it static

        if (name == null || name.trim().isEmpty()) _name = "Unknown";
        else _name = name;

        if (price <= 0) _price = 1.0;
        else _price = price;

        if (stock < 0) _stock = 0;
        else _stock = stock;
    }

    public int getId()
    {
        return _id;
    }

    public String getName()
    {
        return _name;
    }

    public double getPrice()
    {
        return _price;
    }

    public int getStock()
    {
        return _stock;
    }

    public static int getNextId()
    {
        return _nextId;
    }

    public boolean setName(String name)
    {
        if (name == null || name.trim().isEmpty()) return false;
        _name = name.trim();
        return true;
    }

    public boolean setPrice(double price)
    {
        if (price <= 0) return false;
        _price = price;
        return true;
    }

    public boolean setStock(int stock)
    {
        if (stock < 0) return false;
        _stock = stock;
        return true;
    }

    public boolean sell(int quantity)
    {
        if (quantity <= 0 || _stock < quantity) return false;
        _stock -= quantity;
        return true;
    }

    public String getInfo()
    {
        String toReturn = String.format(" id: %d, name: %s, price %.2f, stock: %d", _id, _name, _price, _stock);
        return toReturn;
    }
}