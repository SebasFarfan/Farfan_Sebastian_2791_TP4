package ar.edu.unju.fi.tp4.model;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Component
public class Cliente {
    private String tipoDocumento;
	private int nroDocumento;
	private String nombreApellido;
	private String email;
	private String password;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaNacimiento;
	private int codigoAreaTelefono;
	private int telefono;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaUltimaCompra;


    public Cliente() {
    }

    public Cliente(String tipoDocumento, int nroDocumento, String nombreApellido, String email, String password, LocalDate fechaNacimiento, int codigoAreaTelefono, int telefono, LocalDate fechaUltimaCompra) {
        this.tipoDocumento = tipoDocumento;
        this.nroDocumento = nroDocumento;
        this.nombreApellido = nombreApellido;
        this.email = email;
        this.password = password;
        this.fechaNacimiento = fechaNacimiento;
        this.codigoAreaTelefono = codigoAreaTelefono;
        this.telefono = telefono;
        this.fechaUltimaCompra = fechaUltimaCompra;
    }

    public String getTipoDocumento() {
        return this.tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public int getNroDocumento() {
        return this.nroDocumento;
    }

    public void setNroDocumento(int nroDocumento) {
        this.nroDocumento = nroDocumento;
    }

    public String getNombreApellido() {
        return this.nombreApellido;
    }

    public void setNombreApellido(String nombreApellido) {
        this.nombreApellido = nombreApellido;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getFechaNacimiento() {
        return this.fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getCodigoAreaTelefono() {
        return this.codigoAreaTelefono;
    }

    public void setCodigoAreaTelefono(int codigoAreaTelefono) {
        this.codigoAreaTelefono = codigoAreaTelefono;
    }

    public int getTelefono() {
        return this.telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public LocalDate getFechaUltimaCompra() {
        return this.fechaUltimaCompra;
    }

    public void setFechaUltimaCompra(LocalDate fechaUltimaCompra) {
        this.fechaUltimaCompra = fechaUltimaCompra;
    }

    @Override
    public String toString() {
        return "{" +
            " tipoDocumento='" + getTipoDocumento() + "'" +
            ", nroDocumento='" + getNroDocumento() + "'" +
            ", nombreApellido='" + getNombreApellido() + "'" +
            ", email='" + getEmail() + "'" +
            ", password='" + getPassword() + "'" +
            ", fechaNacimiento='" + getFechaNacimiento() + "'" +
            ", codigoAreaTelefono='" + getCodigoAreaTelefono() + "'" +
            ", telefono='" + getTelefono() + "'" +
            ", fechaUltimaCompra='" + getFechaUltimaCompra() + "'" +
            "}";
    }

    /**
	 * M??todo que calcula la edad en base a la fecha de nacimiento
	 * 
	 * @return Integer que es la cantidad de a??os
	 */
	public int getEdad() {
		int edad = 0;
		LocalDate hoy = LocalDate.now();
		Period periodo = Period.between(this.fechaNacimiento, hoy);
		edad = periodo.getYears();
		return edad;

	}

	/**
	 * m??todo que calcula el tiempo que falta hasta el cumplea??os
	 * 
	 * @return un String que indica la cantidad de a??os, meses, dias, hora, min y
	 *         segundos
	 */
	public String tiempoHastaCumple() {
		String texto = "";
		LocalDate hoy = LocalDate.now();
		int anio;
		if (hoy.getMonthValue() <= this.fechaNacimiento.getMonthValue()) {
			if (hoy.getDayOfMonth() <= this.fechaNacimiento.getDayOfMonth()) {
				anio = hoy.getYear();
			} else {
				anio = hoy.getYear() + 1;
			}
		} else {
			anio = hoy.getYear() + 1;
		}
		LocalDate fechaProxCumple = LocalDate.of(anio, this.fechaNacimiento.getMonth(),
				this.fechaNacimiento.getDayOfMonth());
		Period periodo = Period.between(hoy, fechaProxCumple);
		texto = "A??o:" + periodo.getYears() + " Mes:" + periodo.getMonths() + " D??a:" + periodo.getDays();

		// LocalDateTime
		LocalDateTime ahora = LocalDateTime.now();
		LocalDateTime fechaHoraProxCumple = LocalDateTime.of(anio, this.fechaNacimiento.getMonth(),
				this.fechaNacimiento.getDayOfMonth(), 0, 0, 0);
		Duration duracion = Duration.between(ahora, fechaHoraProxCumple);
		texto = texto + " hora:" + duracion.toHoursPart() + " min:" + duracion.toMinutesPart() + " seg:"
				+ duracion.toSecondsPart();

		return texto;
	}

	/**
	 * M??todo que calcula el tiempo desde la ultima compra hasta el d??a de la fecha
	 * 
	 * @return String que es el tiempo "A??o-Mes-D??a"
	 */
	public String tiempoHastaUltimaCompra() {
		String texto = "";
		LocalDate hoy = LocalDate.now();
		Period periodo = Period.between(this.fechaUltimaCompra, hoy);
		texto = "A??o:" + periodo.getYears() + " Mes:" + periodo.getMonths() + " d??a:" + periodo.getDays();
		return texto;
	}

	/**
	 * M??todo que calcula el tiempo transcurrido desde la fecha de nacimiento
	 * contado en d??as
	 * 
	 * @return String cantidad de d??as
	 */
	public String tiempoDesdeFechaNac() {
		LocalDate hoy = LocalDate.now();
		long numeros_de_dias = ChronoUnit.DAYS.between(fechaNacimiento, hoy);
		return String.valueOf(numeros_de_dias) + " d??as";
	}

}
