package model;

import javafx.scene.control.Menu;

import java.util.Date;
import java.util.LinkedList;

public class Taller {
    private String nombre;
    private String id;
    private String direccion;
    private int materialesDisponibles;
    private LinkedList<Cliente> listClientes;
    private LinkedList<Mecanico> listMecanicos;
    private LinkedList<Bicicleta> listBicicletas;
    private LinkedList<OrdenServicio> listOrdenesServicio;
    private LinkedList<HistorialOrdenesServicio> listHistorialOrdenesServicio;

    //Constructor
    public Taller(String nombre, String id, String direccion, int materialesDisponibles) {
        this.nombre = nombre;
        this.id = id;
        this.direccion = direccion;
        this.materialesDisponibles = materialesDisponibles;
        this.listClientes = new LinkedList<>();
        this.listMecanicos = new LinkedList<>();
        this.listBicicletas = new LinkedList<>();
        this.listOrdenesServicio = new LinkedList<>();
        this.listHistorialOrdenesServicio = new LinkedList<>();
    }

    //Getters y setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getMaterialesDisponibles() {
        return materialesDisponibles;
    }

    public void setMaterialesDisponibles(int materialesDisponibles) {
        this.materialesDisponibles = materialesDisponibles;
    }

    public LinkedList<Cliente> getListClientes() {
        return listClientes;
    }

    public void setListClientes(LinkedList<Cliente> listClientes) {
        this.listClientes = listClientes;
    }

    public LinkedList<Mecanico> getListMecanicos() {
        return listMecanicos;
    }

    public void setListMecanicos(LinkedList<Mecanico> listMecanicos) {
        this.listMecanicos = listMecanicos;
    }

    public LinkedList<Bicicleta> getListBicicletas() {
        return listBicicletas;
    }

    public void setListBicicletas(LinkedList<Bicicleta> listBicicletas) {
        this.listBicicletas = listBicicletas;
    }

    public LinkedList<OrdenServicio> getListOrdenesServicio() {
        return listOrdenesServicio;
    }

    public void setListOrdenesServicio(LinkedList<OrdenServicio> listOrdenesServicio) {
        this.listOrdenesServicio = listOrdenesServicio;
    }

    public LinkedList<OrdenServicio> getOrdenesServicio() {return listOrdenesServicio;}

    public boolean agregarBicicleta(Bicicleta bicicleta) {
        boolean retorno = false;
        if (!verificarSerial(bicicleta.getNumSerial())) {
            listBicicletas.add(bicicleta);
            retorno = true;
        }
        return retorno;
    }

    //Metodo para agregar una orden de servicio a la lista de ordenes de servicio del taller
    public boolean agregarOrdenServicio(OrdenServicio ordenServicio) {
        boolean centinela = false;
        if (!verificarOrdenServicio(ordenServicio.getIdServicio())) {
            listOrdenesServicio.add(ordenServicio);
            centinela = true;
        }
        return centinela;
    }

    //Metodo para verificar la orden de servicio es existente
    public boolean verificarOrdenServicio(String idServicio) {
        boolean verificado = false;
        for (OrdenServicio ordenServicio : listOrdenesServicio) {
            if (ordenServicio.getIdServicio().equals(idServicio)) {
                verificado = true;
            }
        }
        return verificado;
    }
    //Metodo para eliminar ordenes de servicio
    public boolean eliminarOrdenServicio(String idServicio) {
        boolean eliminado = false;
        for (OrdenServicio ordenServicio : listOrdenesServicio) {
            if (ordenServicio.getIdServicio().equals(idServicio)) {
                listOrdenesServicio.remove(ordenServicio);
                eliminado = true;
                break;
            }
        }
        return eliminado;
    }

    //Metodo Actualizar Orden servicio
    public boolean actualizarOrdenServicio(String idOrdenServicio, OrdenServicio ordenServicioActualizado) {
        boolean actualizado = false;
        for (OrdenServicio ordenServicio : listOrdenesServicio) {
            if (ordenServicio.getIdServicio().equals(idOrdenServicio)) {
                ordenServicio.setFechaIngreso(ordenServicioActualizado.getFechaIngreso());
                ordenServicio.setHoraIngreso(ordenServicioActualizado.getHoraIngreso());
                ordenServicio.setMotivoServicio(ordenServicioActualizado.getMotivoServicio());
                ordenServicio.setDiagnostico(ordenServicioActualizado.getDiagnostico());
                ordenServicio.setTrabajoRealizado(ordenServicioActualizado.getTrabajoRealizado());
                ordenServicio.setTrabajoRealizado(ordenServicioActualizado.getTrabajoRealizado());
                ordenServicio.setCostoTotal(ordenServicioActualizado.getCostoTotal());
                actualizado = true;
                break;
            }
        }
        return actualizado;
    }

    //Metodo para agregar cliente a la lista de clientes
    public boolean agregarCliente(Cliente cliente) {
        boolean centinela = false;
        if (!verificarCliente(cliente.getNombre())) {
            listClientes.add(cliente);
            centinela = true;
        }
        return centinela;
    }
    //Metodo para eliminar Cliente de la lista de clientes
        public boolean eliminarCliente(String numIdentificacionCliente) {
        boolean eliminado = false;
        for (Cliente cliente : listClientes) {
            if (cliente.getNumIdentificacion().equals(numIdentificacionCliente)) {
                listOrdenesServicio.remove(cliente);
                eliminado = true;
                break;
            }
        }
        return eliminado;
    }
    //Metodo para modificar un cliente en la lista de clientes
    public boolean actualizarCliente(String numIdentificacion, Cliente cliente) {
        boolean actualizado = false;
        for (Cliente clienteList : listClientes) {
            if (clienteList.getNumIdentificacion().equals(numIdentificacion)) {
                clienteList.setNombre(cliente.getNombre());
                clienteList.setApellido(cliente.getApellido());
                clienteList.setNumIdentificacion(numIdentificacion);
                clienteList.setTelefono(cliente.getTelefono());
                clienteList.setDireccion(cliente.getDireccion());
                actualizado = true;
                break;
            }
        }
        return actualizado;
    }



    //Metodo para verificar que el cliente no esté existente
    public boolean verificarCliente(String numIdentificacion) {
        boolean verificado = false;
        for (Cliente cliente : listClientes) {
            if (cliente.getNumIdentificacion().equals(numIdentificacion)) {
                verificado = true;
            }
        }
        return verificado;
    }

    //Verificar bicicleta registrada por serial
    public boolean verificarSerial(String serial) {
        boolean verificado = false;
        for (Bicicleta bicicleta : listBicicletas) {
            if (bicicleta.getNumSerial().equals(serial)) {
                verificado = true;
            }
        }
        return verificado;
    }

    //buscar historial de ordenes de servicio por serial
    public LinkedList<OrdenServicio> getHistorialServicioSerial(String serial) {
        for (Bicicleta bicicleta : listBicicletas) {
            if (bicicleta.getNumSerial().equals(serial)) {
                return bicicleta.getListOrdenesServicio();
            }
        }
        return null;
    }

    //Buscar ordenes de servicio por fecha
    public LinkedList<OrdenServicio> getHistorialServicioFecha(Date fecha) {
        LinkedList <OrdenServicio> lista = new LinkedList<>();

        for(OrdenServicio ordenServicio : listOrdenesServicio) {
            Date fechaOrden = ordenServicio.getFechaIngreso();

            if (fechaOrden != null && fechaOrden.getYear() == fecha.getYear() && fechaOrden.getMonth() == fecha.getMonth() && fechaOrden.getDate() == fecha.getDate()) {
                lista.add(ordenServicio);
            }
        }
        return lista;
    }

    //Crear mensaje de alerta de stock bajo
    public String crearMensajeAlertaStockBajo() {
        if (this.getMaterialesDisponibles() < 50) {
            return "Alerta, stock de materiales bajo, quedan " + materialesDisponibles + " disponibles.";
        } else
            return "Todo perfecto, hay suficientes materiales, quedan " + materialesDisponibles + " disponibles.";
    }





    //metodo para consultar el historial de servicios por serial de bicicleta
    public LinkedList<OrdenServicio> verHistorialServicioSerial (String serial) {
        return null;
    }


    //Metodo para crear mecanico y agregarlo a la lista
    public boolean agregarMecanico(Mecanico mecanico) {
        boolean centinela = false;
        if (!verificarMecanico(mecanico.getId())) {
            listMecanicos.add(mecanico);
            centinela = true;
        }
        return centinela;
    }
    //Metodo para eliminar mecanico de la lista de mecanicos
    public boolean eliminarMecanico(String iDMecanico) {
        boolean eliminado = false;
        for (Mecanico mecanico : listMecanicos) {
            if (mecanico.getId().equals(iDMecanico)) {
                listMecanicos.remove(mecanico);
                eliminado = true;
                break;
            }
        }
        return eliminado;
    }
    //Metodo para modificar un mecanico en la lista de mecanicos
    public boolean actualizarMecanico(String numIdentificacion, Mecanico mecanico) {
        boolean actualizado = false;
        for (Mecanico mecanicoList : listMecanicos) {
            if (mecanico.getId().equals(numIdentificacion)) {
                mecanicoList.setNombre(mecanico.getNombre());
                mecanicoList.setApellido(mecanico.getApellido());
                mecanicoList.setId(numIdentificacion);
                actualizado = true;
                break;
            }
        }
        return actualizado;
    }

    //Metodo para verificar mecanico
    public boolean verificarMecanico(String serial) {
        boolean verificado = false;
        for (Bicicleta bicicleta : listBicicletas) {
            if (bicicleta.getNumSerial().equals(serial)) {
                verificado = true;
            }
        }
        return verificado;
    }



    @Override
    public String toString() {
        return "Nombre: " + nombre + "/n"
                + ", Id: " + id + "/n"
                + ", Direccion: " + direccion;
    }

    public LinkedList<HistorialOrdenesServicio> getListHistorialOrdenesServicio() {
        return listHistorialOrdenesServicio;
    }

    public void setListHistorialOrdenesServicio(LinkedList<HistorialOrdenesServicio> listHistorialOrdenesServicio) {
        this.listHistorialOrdenesServicio = listHistorialOrdenesServicio;
    }
}
