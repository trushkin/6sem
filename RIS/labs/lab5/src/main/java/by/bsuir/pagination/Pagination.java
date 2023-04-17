package by.bsuir.pagination;

import by.bsuir.entity.Customer;
import by.bsuir.repository.CustomerService;
import by.bsuir.repository.CustomerServiceBean;
import jakarta.ejb.EJB;
import jakarta.faces.bean.ManagedBean;
import jakarta.inject.Inject;

import java.util.ArrayList;
import java.util.List;

@ManagedBean
public class Pagination {
    @EJB
    private CustomerService repository;
    private List<Customer> dataList;
    private int pageNumber = 1;
    private int pageSize = 5;
    private int totalPages;
    private List<Customer> allCustomers;

    public void setCurrentCustomersList(int start, int count) {
        dataList = new ArrayList<>();
        int step = count;
        if (allCustomers.size() < start + count) {
            step = allCustomers.size() % count;
        }
        for (int i = start; i < start + step; i++) {
            dataList.add(allCustomers.get(i));
        }
    }

    public List<Customer> loadPageData() {
        if(allCustomers == null) {
            allCustomers = repository.getAllCustomers();
        }
        setCurrentCustomersList((pageNumber - 1) * pageSize, pageSize);
        return dataList;
    }

    public int countTotalPages() {
        if(allCustomers == null) {
            allCustomers = repository.getAllCustomers();
        }
        totalPages = allCustomers.size() / pageSize;
        if(allCustomers.size() % pageSize != 0) {
            totalPages++;
        }
        return totalPages;
    }

    public void nextPage() {
        pageNumber++;
    }

    public void previousPage() {
        pageNumber--;
    }

    public boolean hasNextPage() {
        return pageNumber < totalPages;
    }

    public boolean hasPreviousPage() {
        return pageNumber > 1;
    }

    public void goToPage(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public void changePageSize() {
        pageNumber = 1;
        loadPageData();
    }

    public List<Customer> getDataList() {
        return dataList;
    }

    public void setDataList(List<Customer> dataList) {
        this.dataList = dataList;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
