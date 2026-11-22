public class Main
{
    public static void main(String[] args)
    {
        Store store = new Store("test", 3);

        Product notebook = new Product("notebook", 12.5, 3);
        Product pen = new Product("Pen", 4.0, 2);
        Product bottle = new Product("Bottle", 30.0, 0);

        boolean notebookResult = store.addProduct(notebook);
        boolean penResult = store.addProduct(pen);
        boolean bottleResult = store.addProduct(bottle);
        System.out.printf("%s addition returned: %b \n", notebook.getName(), notebookResult);
        System.out.printf("%s addition returned: %b \n", pen.getName(), penResult);
        System.out.printf("%s addition returned: %b \n", bottle.getName(), bottleResult);

        Product pencil = new Product("pencil", 6, 5); ///store full should fail
        boolean newProductResult = store.addProduct(pencil);
        System.out.printf("%s addition gave %b as the store is full\n", pencil.getName(), newProductResult);

        boolean soldNotebook = store.sellProduct(notebook.getId(), 2);
        System.out.printf("sold 2 %s and returned %b\n", notebook.getName(), soldNotebook);
        boolean soldPen1 = store.sellProduct(pen.getId(), 3);
        System.out.printf("sold 3 %s and got %b \n", pen.getName(), soldPen1);
        boolean soldPen2 = store.sellProduct(pen.getId(), 2);
        System.out.printf("Sold 2 %s and got %b\n", pen.getName(), soldPen2);

        boolean priceUpdateResult = notebook.setPrice(-5);
        System.out.printf("%s's price changed to -5 and the change operation gave was %b - current price: %.2f\n", notebook.getName(), priceUpdateResult, notebook.getPrice());

        System.out.println("***OUT OF STOCK PRODUCTS: ");
        store.printAvailableProducts();

        System.out.println("******SALE REPORT*****");
        store.printSalesReport();
        int totalSold = store.getTotalUnitsSold();
        System.out.printf("units sold in total: %d", totalSold);

        System.out.println("****IDs for products bought next");
        System.out.printf("%s id: %d\n", notebook.getName(), notebook.getId());
        System.out.printf("%s id: %d\n", pen.getName(), pen.getId());
        System.out.printf("%s id: %d\n", bottle.getName(), bottle.getId());
        System.out.printf("%s id: %d\n", pencil.getName(), pencil.getId());
        System.out.printf("The next id is %d\n", Product.getNextId());
    }
}