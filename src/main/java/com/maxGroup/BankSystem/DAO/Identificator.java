package com.maxGroup.BankSystem.DAO;

import java.io.Serializable;

public interface Identificator<PK extends Serializable> {

    public PK getId();
}
