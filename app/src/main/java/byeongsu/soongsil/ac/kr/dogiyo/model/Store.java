package byeongsu.soongsil.ac.kr.dogiyo.model;

/**
 * Created by bosslab on 18. 6. 10.
 */

public class Store {

    private String storeName;
    private String storeCategory;
    private String storeTel;
    private int storeImageResId;

    public Store(String storeName, String storeCategory, String storeTel, int storeImageResId) {
        this.storeName = storeName;
        this.storeCategory = storeCategory;
        this.storeTel = storeTel;
        this.storeImageResId = storeImageResId;
    }

    public int getStoreImageResId() {
        return storeImageResId;
    }

    public void setStoreImageResId(int storeImageResId) {
        this.storeImageResId = storeImageResId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getStoreCategory() {
        return storeCategory;
    }

    public void setStoreCategory(String storeCategory) {
        this.storeCategory = storeCategory;
    }

    public String getStoreTel() {
        return storeTel;
    }

    public void setStoreTel(String storeTel) {
        this.storeTel = storeTel;
    }
}
