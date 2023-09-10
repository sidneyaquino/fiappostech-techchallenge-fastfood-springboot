package com.fiappostech.fastfood.adapter.presenter.customer;

import com.fiappostech.fastfood.adapter.presenter.customer.response.CustomerResponseFull;

public interface CustomerIdentifyPresenter {
   public CustomerResponseFull execute(String personalId);
}