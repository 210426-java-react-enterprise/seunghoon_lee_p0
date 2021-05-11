package com.revature.seunghoon_lee_p0.services;

import com.revature.seunghoon_lee_p0.daos.AccountDAO;

public class AccountService {

    private AccountDAO accountDAO;

    public AccountService(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }


}
