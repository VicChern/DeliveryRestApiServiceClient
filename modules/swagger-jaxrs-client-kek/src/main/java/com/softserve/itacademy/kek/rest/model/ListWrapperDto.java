package com.softserve.itacademy.kek.rest.model;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import io.swagger.annotations.ApiModelProperty;

public class ListWrapperDto<T> {
    @ApiModelProperty(value = "")
    private List<T> list;

    public ListWrapperDto() {
        this(new LinkedList<T>());
    }

    public ListWrapperDto(List<T> list) {
        this.list = list;
    }


    public List<T> getList() {
        return list;
    }

    public ListWrapperDto<T> addKekItem(T item) {
        list.add(item);

        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ListWrapperDto)) return false;
        ListWrapperDto<?> that = (ListWrapperDto<?>) o;
        return Objects.equals(list, that.list);
    }

    @Override
    public int hashCode() {
        return Objects.hash(list);
    }

    @Override
    public String toString() {
        return "ListDto{"
                + "list="
                + list.stream().map(T::toString)
                .collect(Collectors.joining(","))
                + '}';
    }
}
