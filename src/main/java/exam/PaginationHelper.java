package exam;

import java.util.List;

// TODO: 完成这个类

public class PaginationHelper<I> {

    /**
     * 构造函数包含
     * 1）数组collection，表示需要分页的所有元素
     * 2）数字itemsPerPage，表示每页的元素个数
     */
    List<I> collection;
    int itemsPerPage;
    public PaginationHelper(List<I> collection, int itemsPerPage) {
        this.collection = collection;
        this.itemsPerPage = itemsPerPage;
    }

    /**
     * 返回collection中所有元素的个数
     */
    public int itemCount() {
        return this.collection.size();
    }


    /**
     * 返回页数
     */
    public int pageCount() {
        return this.itemCount() % this.itemsPerPage == 0 ? this.itemCount() / this.itemsPerPage : this.itemCount() / this.itemsPerPage +1;
    }

    /**
     * 返回当前页pageIndex中所包含的元素个数
     * pageIndex从0开始计数
     * 如果pageIndex为非法值则返回-1
     */
    public int pageItemCount(int pageIndex) {
        if (pageIndex < 0 || pageIndex >= this.pageCount()){
            return -1;
        }
        else if (pageIndex == this.pageCount()-1) {
            return this.itemCount() - (this.pageCount() - 1) * this.itemsPerPage;
        }
        else{
            return this.itemsPerPage;
        }
    }

    /**
     * 返回第itemIndex个元素所在的页数
     * pageIndex从0开始计数
     * 如果itemIndex为非法值则返回-1
     */
    public int pageIndex(int itemIndex) {
        if (itemIndex < 0 || itemIndex >= this.itemCount()){
            return -1;
        }
        else{
            return (itemIndex / 4);
        }
    }
}