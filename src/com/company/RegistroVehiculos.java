package com.company;

import java.util.*;
import java.util.stream.Collectors;

public class RegistroVehiculos {
    private Set<Coche> coches = new HashSet<>();

    public void registrarVehiculo(Coche coche) {

        coches.add(coche);
    }

    // Optional<Coche> es una nueva funcionalidad de Java 8 para evitar trabajar con null
    // Lo puedes omitir si trabajas con Java 7
    public Optional<Coche> obtenerVehiculo(String matricula) {

        return coches.stream().filter(coche -> coche.getMatricula().equalsIgnoreCase(matricula)).findFirst();

    }

    public void eliminarVehiculo(String matricula) {

        coches.removeIf(coche -> coche.getMatricula().equalsIgnoreCase(matricula));

    }

    public Optional<Coche> obtenerVehiculoPrecioMax() {

        return coches.stream().max(Comparator.comparing(Coche::getPrecio));

    }

    public List<Coche> obtenerVehiculosMarca(String marca) {

        return coches.stream()
                .filter(coche -> coche.getMarca().equalsIgnoreCase(marca))
                .collect(Collectors.toList());
    }

    public Set<Coche> obtenerTodos() {

        return coches;
    }
}