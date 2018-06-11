package byeongsu.soongsil.ac.kr.dogiyo.model;

/**
 * Created by bosslab on 18. 6. 11.
 */

public class ListStore {

    private String storeName;
    private String storeCategory;
    private String storeTel;
    private boolean isFavorite;

    public ListStore(String storeName, String storeCategory, String storeTel, boolean isFavorite) {
        this.storeName = storeName;
        this.storeCategory = storeCategory;
        this.storeTel = storeTel;
        this.isFavorite = isFavorite;
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

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }
}
