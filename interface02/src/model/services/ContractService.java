package model.services;

import java.time.LocalDate;

import model.entities.Contract;
import model.entities.Installment;

public class ContractService {

	private OnlinePaymentService onlinePaymentService;

	public ContractService() {
	}

	// Inversion of Control by Dependency Injection
	public ContractService(OnlinePaymentService onlinePaymentService) {
		super();
		this.onlinePaymentService = onlinePaymentService;
	}

	public void processContract(Contract contract, Integer months) {

		double basicQuota = contract.getTotalValue() / months;

		for (int i = 1; i <= months; i++) {
			LocalDate dueDate = contract.getDate().plusMonths(i);

			// interest means 'juros' in Portuguese language
			double interest = onlinePaymentService.interest(basicQuota, i);
			double paymentFee = onlinePaymentService.paymentFee(basicQuota + interest);
			double fullQuota = basicQuota + interest + paymentFee;

			contract.addInstallment(new Installment(dueDate, fullQuota));

		}
	}

}