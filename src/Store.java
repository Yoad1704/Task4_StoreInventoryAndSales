public class Store
{
    private String _storeName;
    private Product[] _products;
    private int[] _soldCount;
    private int _productCount;

    public Store(String storeName, int capacity)
    {
        _storeName = storeName;
        _products = new Product[capacity];
        _soldCount = new int[capacity];
        _productCount = 0;
    }

    public boolean addProduct(Product product)
    {
        if (product == null) return false;
        if (_productCount >= _products.length) return false;

        int existingIndex = findProductIndex(product.getId());
        if (existingIndex != -1) return false;

        _products[_productCount] = product;
        _soldCount[_productCount] = 0;
        _productCount++;
        return true;
    }

    public int findProductIndex(int id)
    {
        int index = 0;
        int foundIndex = -1;
        while (index < _productCount)
        {
            if (_products[index].getId() == id)
            {
                foundIndex = index;
                break;
            }
            index++;
        }
        return foundIndex;
    }

    public boolean sellProduct(int id, int quantity)
    {
        int index = findProductIndex(id);
        if (index == -1) return false;

        Product targetProduct = _products[index];
        boolean isSold = targetProduct.sell(quantity);
        if (!isSold) return false;
        _soldCount[index] += quantity;
        return true;
    }

    public void printAvailableProducts()
    {
        System.out.printf("Available products in %s\n", _storeName);

        for (int i = 0; i < _productCount; i++)
        {
            Product currentProduct = _products[i];
            if (currentProduct.getStock() <= 0) continue; //out of stock move to next product

            String toPrint = currentProduct.getInfo();
            System.out.println(toPrint);
        }
    }

    public void printSalesReport()
    {
        System.out.println("Sales report for " + _storeName);

        for (int i = 0; i < _productCount; i++)
        {
            String productName = _products[i].getName();
            int unitsSold = _soldCount[i];
            System.out.printf("\n %d units were sold of product %s", unitsSold, productName);
        }
    }

    public int getTotalUnitsSold()
    {
        int totalSold = 0;
        for (int i = 0; i < _productCount; i++)
        {
            totalSold += _soldCount[i];
        }
        return totalSold;
    }
}