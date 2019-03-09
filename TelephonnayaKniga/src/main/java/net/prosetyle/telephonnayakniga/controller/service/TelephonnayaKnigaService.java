package net.prosetyle.telephonnayakniga.controller.service;

import net.prosetyle.telephonnayakniga.controller.entity.Telephonnaya_Kniga;

import java.util.List;

public interface TelephonnayaKnigaService {
    public void addTelephonnayaKniga(Telephonnaya_Kniga telephonnaya_kniga);

    public void updateTelephonnayaKniga(Telephonnaya_Kniga telephonnaya_kniga);

    public void  removeTelephonnayaKniga(Integer id);

    public Telephonnaya_Kniga getTelephonnayaKnigaById(Integer id);

    public List<Telephonnaya_Kniga> listTelephonnayaKniga();
}
