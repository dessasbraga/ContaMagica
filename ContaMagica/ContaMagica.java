package ContaMagica;

public class ContaMagica {

	private String nomeCliente;
    private double saldo;
    private Categorias status;
	

    public ContaMagica(String nome) {
        nomeCliente = nome;
        saldo = 0.0;
        status = Categorias.Silver;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public double getSaldo() {
        return saldo;
    }

    public Categorias getStatus() {
        return status;
    }
    
    public void deposito(double valor) {
        if (valor < 0) {
            return;
        }
        switch (status) {
            case Silver:
                saldo += valor;
                break;
            case Gold:
                saldo += (valor * 1.01);
                break;
            case Platinum:
                saldo += (valor * 1.025);
                break;      
        }
        if ((saldo >= 50000) && (status == Categorias.Silver)) {
            status = Categorias.Gold;
        } else if ((saldo >= 200000) && (status == Categorias.Gold)) {
            status = Categorias.Platinum;
        } else {
            status = Categorias.Silver;
        }
    }
    public boolean retirada(double valor) {
        if (saldo - valor < 0) {
            return (false);
        }
        saldo -= valor;
        if (status == Categorias.Silver) {
            return (true);
        } else if (saldo < 100000.0) {
            status = Categorias.Gold;
            return (true);
        } else if (saldo < 25000.0) {
            status = Categorias.Silver;
            return (true);
        }
        return (true);
    }
    public void setSaldo(double s) {
        saldo = s;
    }
    public void setStatus(Categorias c) {
        status = c;
    }
}

