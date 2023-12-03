/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.util.Date;

public class ViewModelFacturas {

    private int IdFactura;
    private int IDFormadePago;
    private int IdCliente;
    private int IdUsuario;
    private String totalCompra;

    public ViewModelFacturas() {
    }

    public int getIdUsuario() {
        return IdUsuario;
    }

    public void setIdUsuario(int IdUsuario) {
        this.IdUsuario = IdUsuario;
    }
    
    
    /**
     * @return the IdFactura
     */
    public int getIdFactura() {
        return IdFactura;
    }

    /**
     * @param IdFactura the IdFactura to set
     */
    public void setIdFactura(int IdFactura) {
        this.IdFactura = IdFactura;
    }

    /**
     * @return the IDFormadePago
     */
    public int getIDFormadePago() {
        return IDFormadePago;
    }

    /**
     * @param IDFormadePago the IDFormadePago to set
     */
    public void setIDFormadePago(int IDFormadePago) {
        this.IDFormadePago = IDFormadePago;
    }

    /**
     * @return the IdCliente
     */
    public int getIdCliente() {
        return IdCliente;
    }

    /**
     * @param IdCliente the IdCliente to set
     */
    public void setIdCliente(int IdCliente) {
        this.IdCliente = IdCliente;
    }

    /**
     * @return the IdUsusario
     */
    public int getIdUsusario() {
        return IdUsuario;
    }

    /**
     * @param IdUsusario the IdUsusario to set
     */
    public void setIdUsusario(int IdUsusario) {
        this.IdUsuario = IdUsusario;
    }

    /**
     * @return the totalCompra
     */
    public String getTotalCompra() {
        return totalCompra;
    }

    /**
     * @param totalCompra the totalCompra to set
     */
    public void setTotalCompra(String totalCompra) {
        this.totalCompra = totalCompra;
    }
}
