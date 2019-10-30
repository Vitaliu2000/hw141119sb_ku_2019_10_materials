package ru.itvitality.sbrf.cu.rj.atm.atm;

import ru.itvitality.sbrf.cu.rj.atm.Nominal;

import java.util.List;

public interface ATM {
    void putCash( List<Nominal> cashList);
    List<Nominal> getCash(Integer sum);
}
