package cn.dywei.pojo;

// 根据目前需求分析出来的商品集合中需要包含的内容
public class Item {
    // 主键
    private String id;
    // 标题
    private String title;
    // 商品图片
    private String img;
    // 点击跳转
    private String link;
    // 销量
    private Integer sales;
    // 是否为热门
    private Boolean recommendation;
    // 热门排序
    private Integer recoSort;
    // 所属城市
    private String city;


    public Boolean getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(Boolean recommendation) {
        this.recommendation = recommendation;
    }

    public Integer getRecoSort() {
        return recoSort;
    }

    public void setRecoSort(Integer recoSort) {
        this.recoSort = recoSort;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getSales() {
        return sales;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
