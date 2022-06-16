package org.prueba.service.impl;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.prueba.Utilitarios.Utils;
import org.prueba.entity.Cliente;
import org.prueba.entity.ClienteDetalle;
import org.prueba.entity.ClienteKpi;
import org.prueba.repository.ClienteRepository;
import org.prueba.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl implements ClienteService {

	
	@Autowired
	ClienteRepository repositorycliente;
	

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public List<Cliente> FindAll() {
		return repositorycliente.findAll();
	}

	@Override
	public Cliente FindById(Long id) {
		return repositorycliente.findById(id).get();
	}

	@Override
	public Cliente Save(Cliente persona) {
		Cliente savedPersona = repositorycliente.save(persona);
		return savedPersona;
	}

	@Override
	public ClienteKpi kpIdeClientes() {
		Collection<Cliente> clientes = repositorycliente.findAll();
		List<Integer> edades = clientes.stream()
				.map(Cliente::getEdad).collect(Collectors.toList());

		double promedio = Utils.promedioEdades(edades.stream().mapToInt(x -> x).toArray());
		double desviacion = Utils.desviacionEstandar(edades.stream().mapToInt(x -> x).toArray());
		ClienteKpi respuesta = new ClienteKpi() {
			{
				setPromedioEdades(promedio);
				setDesviacionEstandarEdades(desviacion);
			}
		};
		return respuesta;
	}

	@Override
	public List<ClienteDetalle> listClientes() {
		List<Cliente> clientes = repositorycliente.findAll();
		List<ClienteDetalle> clientesDetalle = clientes.stream()
				.map(cliente -> convertToClienteDetaille(cliente))
				.collect(Collectors.toList());

		clientesDetalle.stream().forEach(u -> u.setFechaProbableMuerte(Utils.fechaProbableMuerte()));
		return clientesDetalle;
	}

	private ClienteDetalle convertToClienteDetaille(Cliente cliente) {
		ClienteDetalle clienteDetailsDto = modelMapper.map(cliente, ClienteDetalle.class);
		return clienteDetailsDto;
	}

}
