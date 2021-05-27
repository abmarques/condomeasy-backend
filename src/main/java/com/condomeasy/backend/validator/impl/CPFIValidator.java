package com.condomeasy.backend.validator.impl;

import java.util.InputMismatchException;

import com.condomeasy.backend.dto.UserDTO;
import com.condomeasy.backend.exception.BusinessException;
import com.condomeasy.backend.repository.IUserRepository;
import com.condomeasy.backend.validator.IValidator;

public class CPFIValidator implements IValidator {

	private IUserRepository userRepository;
	private IValidator proximo;

	@Override
	public void validate(UserDTO user) {
		if (user.getCpf().equals("00000000000") || user.getCpf().equals("11111111111")
				|| user.getCpf().equals("22222222222") || user.getCpf().equals("33333333333")
				|| user.getCpf().equals("44444444444") || user.getCpf().equals("55555555555")
				|| user.getCpf().equals("66666666666") || user.getCpf().equals("77777777777")
				|| user.getCpf().equals("88888888888") || user.getCpf().equals("99999999999")
				|| (user.getCpf().length() != 11))
			throw new BusinessException("CPF inválido.");

		char dig10, dig11;
		int sm, i, r, num, peso;

		try {

			sm = 0;
			peso = 10;
			for (i = 0; i < 9; i++) {

				num = (int) (user.getCpf().charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso - 1;
			}

			r = 11 - (sm % 11);
			if ((r == 10) || (r == 11))
				dig10 = '0';
			else
				dig10 = (char) (r + 48);

			sm = 0;
			peso = 11;
			for (i = 0; i < 10; i++) {
				num = (int) (user.getCpf().charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso - 1;
			}

			r = 11 - (sm % 11);
			if ((r == 10) || (r == 11))
				dig11 = '0';
			else
				dig11 = (char) (r + 48);

			if (!(dig10 == user.getCpf().charAt(9)) && (dig11 == user.getCpf().charAt(10)))
				throw new BusinessException("CPF inválido.");
		} catch (InputMismatchException erro) {
			throw new BusinessException("CPF inválido.");
		}

		if (proximo != null) {
			proximo.setUserRepository(userRepository);
			proximo.validate(user);
		}
	}

	@Override
	public void setProximo(IValidator proximo) {
		this.proximo = proximo;
	}

	@Override
	public void setUserRepository(IUserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public IValidator getProximo() {
		return this.proximo;
	}

}
