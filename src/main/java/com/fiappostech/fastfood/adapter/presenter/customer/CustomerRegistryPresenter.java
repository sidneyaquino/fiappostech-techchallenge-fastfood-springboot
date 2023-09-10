package com.fiappostech.fastfood.adapter.presenter.customer;

import com.fiappostech.fastfood.adapter.presenter.customer.request.CustomerPostRequest;
import com.fiappostech.fastfood.adapter.presenter.customer.response.CustomerResponseFull;

public interface CustomerRegistryPresenter {
   public CustomerResponseFull execute(CustomerPostRequest customerPostRequest);
}