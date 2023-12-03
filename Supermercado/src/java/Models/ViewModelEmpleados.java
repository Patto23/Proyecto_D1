/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.util.Date;

public class ViewModelEmpleados {
    
    private int IdEmpleado;
    private String nombresEmpleados;
    private String apellidosEmpleados;
    private String fechaNacEmpleados;
    private String telefono;
    private String correo;
    
    

    /**
     * @return the IdEmpleado
     */
    public int getIdEmpleado() {
        return IdEmpleado;
    }

    /**
     * @param IdEmpleado the IdEmpleado to set
     */
    public void setIdEmpleado(int IdEmpleado) {
        this.IdEmpleado = IdEmpleado;
    }

    /**
     * @return the nombresEmpleados
     */
    public String getNombresEmpleados() {
        return nombresEmpleados;
    }

    /**
     * @param nombresEmpleados the nombresEmpleados to set
     */
    public void setNombresEmpleados(String nombresEmpleados) {
        this.nombresEmpleados = nombresEmpleados;
    }

    /**
     * @return the apellidosEmpleados
     */
    public String getApellidosEmpleados() {
        return apellidosEmpleados;
    }

    /**
     * @param apellidosEmpleados the apellidosEmpleados to set
     */
    public void setApellidosEmpleados(String apellidosEmpleados) {
        this.apellidosEmpleados = apellidosEmpleados;
    }

    /**
     * @return the fechaNacEmpleados
     */
    public String getFechaNacEmpleados() {
        return fechaNacEmpleados;
    }

    /**
     * @param fechaNacEmpleados the fechaNacEmpleados to set
     */
    public void setFechaNacEmpleados(String fechaNacEmpleados) {
        this.fechaNacEmpleados = fechaNacEmpleados;
    }

    /**
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * @return the correo
     */
    public String getCorreo() {
        return correo;
    }

    public ViewModelEmpleados() {
    }

    public ViewModelEmpleados(int IdEmpleado, String nombresEmpleados, String apellidosEmpleados, String fechaNacEmpleados, String telefono, String correo) {
        this.IdEmpleado = IdEmpleado;
        this.nombresEmpleados = nombresEmpleados;
        this.apellidosEmpleados = apellidosEmpleados;
        this.fechaNacEmpleados = fechaNacEmpleados;
        this.telefono = telefono;
        this.correo = correo;
    }

    /**
     * @param correo the correo to set
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
