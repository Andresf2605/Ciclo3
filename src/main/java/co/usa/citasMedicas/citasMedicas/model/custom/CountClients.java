package co.usa.citasMedicas.citasMedicas.model.custom;

import co.usa.citasMedicas.citasMedicas.model.Cliente;

public class CountClients {
    private Long total;
    private Cliente client;

    public CountClients(Long total, Cliente client) {
        this.total = total;
        this.client = client;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Cliente getClient() {
        return client;
    }

    public void setClient(Cliente client) {
        this.client = client;
    }
}
