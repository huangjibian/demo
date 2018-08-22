package Observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class ProductList extends Observable {
    private List<String> productList = null;//产品列表
    private  static ProductList instance;//类唯一实例
    private ProductList(){}//构造方法私有化

    /**获取唯一实例
    *
    * return 产品列表唯一实例
    */

    public static ProductList getInstance(){
        if (instance==null){
            instance = new ProductList();
            instance.productList = new ArrayList<String>();
        }
        return instance;
    }

    /**
     * 增加观察者（电商接口）
     * @param observer
     */
    public  void addproductListObserver(Observer observer) {
        this.addObserver(observer);
    }

    /**
     * 新增产品
     * @param newProduct
     */
    public void addProduct(String newProduct){
        productList.add(newProduct);
        System.out.println("产品列表新增了产品 :" +newProduct);
        this.setChanged();               // 设置观察者对象发生变化
        this.notifyObservers(newProduct);//通知观察者,并传递新产品
    }

    public static void main(String[] args) {
        ProductList observer = ProductList.getInstance();
        TaoBaoObserver t = new TaoBaoObserver();
        JingDongObserver j = new JingDongObserver();
        observer.addproductListObserver(t);
        observer.addproductListObserver(j);
        observer.addProduct("新产品:哇哈哈");
    }
}
