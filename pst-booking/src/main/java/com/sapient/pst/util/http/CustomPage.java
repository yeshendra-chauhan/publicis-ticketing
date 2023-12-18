package com.sapient.pst.util.http;

import java.util.List;

import org.springframework.data.domain.Page;

import lombok.Data;

@Data
public class CustomPage<T> {
 
  private List<T> content;
  private CustomPageable pageable;

  public CustomPage(Page<T> page) {
    this.content = page.getContent();
    this.pageable = new CustomPageable(page.getPageable().getPageNumber(),
        page.getPageable().getPageSize(), page.getTotalElements());
  }

  @Data
  class CustomPageable {
    int pageNumber;
    int pageSize;
    long totalElements;
    boolean hasMore;

    public CustomPageable(int pageNumber, int pageSize, long totalElements) {

      this.pageNumber = pageNumber;
      this.pageSize = pageSize;
      this.totalElements = totalElements;
      this.hasMore = (totalElements<pageSize);
    }
  }
}