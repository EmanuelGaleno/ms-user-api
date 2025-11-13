package io.emanuel.ms_user_api.domain.validators;

import br.com.fluentvalidator.AbstractValidator;
import io.emanuel.ms_user_api.domain.entity.User;

import static br.com.fluentvalidator.predicate.LogicalPredicate.not;
import static br.com.fluentvalidator.predicate.StringPredicate.stringEmptyOrNull;

public class UserValidator extends AbstractValidator<User> {

    @Override
    public void rules() {

        ruleFor(user -> user.getName() != null ? user.getName().value() : null)
                .must(not(stringEmptyOrNull()))
                .withMessage("O nome é obrigatório.");

        ruleFor(user -> user.getEmail() != null ? user.getEmail().value() : null)
                .must(not(stringEmptyOrNull()))
                .withMessage("O e-mail é obrigatório.");

        ruleFor(User::getActive)
                .must(a -> a == null || a.equals(true) || a.equals(false))
                .withMessage("Campo 'active' deve ser booleano.");
    }
}