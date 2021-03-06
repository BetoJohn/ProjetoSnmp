/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.snmp.BO;

import br.com.snmp.DAO.SnmpDAO;
import br.com.snmp.connection.ConnectionDB;
import br.com.snmp.model.Device;
import br.com.snmp.model.OID;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author carlos.macedo
 */
public class SnmpBO {

    private static SnmpBO snmpBO;

    private SnmpBO() {
    }

    public static SnmpBO getInstance() {
        if (snmpBO == null) {
            snmpBO = new SnmpBO();
        }
        return snmpBO;
    }

    public void insertDevice(Device dev) throws Exception {
        Connection con = null;
        try {

            con = ConnectionDB.getInstance().getConnection();
            SnmpDAO dao = new SnmpDAO(con);
            dao.insertDevice(dev);

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            con.close();
        }
    }

    public List<Device> getAllDevices() throws Exception {
        Connection con = null;
        try {
            con = ConnectionDB.getInstance().getConnection();
            SnmpDAO dao = new SnmpDAO(con);
            return dao.getAllDevices();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            con.close();
        }

    }

 public void insertOID(OID oid) throws Exception {
        Connection con = null;
        try {

            con = ConnectionDB.getInstance().getConnection();
            SnmpDAO dao = new SnmpDAO(con);
            dao.insertOID(oid);

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            con.close();
        }
    }
 
public List<OID> getAllOID() throws Exception {
        Connection con = null;
        try {

            con = ConnectionDB.getInstance().getConnection();
            SnmpDAO dao = new SnmpDAO(con);
            return dao.getAllOID();

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            con.close();
        }
    }

//    public List<Device> getByIdentificacao(Device dev) {
//        return SnmpDAO.getInstance().getByIdentificacao(dev);
//    }
//
//    public void refreshTable() {
//        SnmpDAO.getInstance().refreshTable();
//    }
}
