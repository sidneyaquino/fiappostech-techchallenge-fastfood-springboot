package com.fiappostech.fastfood.adapter.presenter.customer;

import java.util.UUID;

import com.fiappostech.fastfood.adapter.presenter.customer.response.CustomerResponseFull;

public interface CustomerFindByIdPresenter {
   public CustomerResponseFull execute(UUID customerId);
}