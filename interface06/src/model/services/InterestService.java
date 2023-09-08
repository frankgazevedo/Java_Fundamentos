package model.services;

import java.security.InvalidParameterException;

public interface InterestService {

	double getInterestRate();

	/*
	 * PORTUGUESE LANGUAGE
	 * Default methods (defender methods) 
	 * Objetivo: prover implementação padrão para métodos, de modo a evitar: 
	 * 1) repetição de implementação em toda classe que implemente a interface 
	 * 2) a necessidade de se criar classes abstratas para prover reuso da implementação
	 * 
	 * Outras vantagens: 
	 * 1) Manter a retrocompatibilidade com sistemas existentes 
	 * 2) Permitir que "interfaces funcionais" (que devem conter apenas um método) 
	 * possam prover outras operações padrão reutilizáveis.
	 * 
	 * Considerações importantes: 
	 * 01) Sim: agora as interfaces podem prover reuso 
	 * 02) Sim: agora temos uma forma de herança múltipla, embora o compilador reclame, 
	 * se houver mais de um método com a mesma assinatura, obrigando a sobrescrevê-lo 
	 * 03) Interfaces ainda são bem diferentes de classes abstratas. Interfaces não 
	 * possuem recursos tais como construtores e atributos
	 * 
	 * ENGLISH LANGUAGE:
	 * Purpose: provide default implementation for methods in order to avoid:
	 * 1) implementation repetition in each class that implements any interface
	 * 2) the need to create abstract classes to allow implementation reuse
	 * 
	 * Other advantages:
	 * 1) Maintain backward compatibility with existing systems
	 * 2) Allowing "functional interfaces" (which should only contain one method) 
	 * can provide other reusable default methods (defender methods)
	 * 
	 * Important considerations:
	 * 1) Interfaces can now provide reuse.
	 * 2) now we have a form of multiple inheritance, although the compiler complains, 
	 * if there is more than one method with the same signature, forcing it to override it.
	 * 3) interfaces are still different from abstract classes. Interfaces do not have 
	 * features like constructors and attributes.
	 * 
	 * 
	 */

	default double payment(double amount, int months) {
		if (months < 1) {
			throw new InvalidParameterException("Months must be greater than zero");
		}
		return amount * Math.pow(1.0 + getInterestRate() / 100.0, months);
	}
}
