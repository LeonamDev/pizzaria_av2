/*
 * Copyright 2018 JoinFaces.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package pos.java.pizzaria.converter;

import java.util.Optional;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pos.java.pizzaria.model.Endereco;
import pos.java.pizzaria.model.Ingrediente;
import pos.java.pizzaria.service.EnderecoService;

/**
 *
 * @author leonam
 */
@Component
public class EnderecoConverter implements Converter {

    @Autowired
    EnderecoService enderecoService;

    @Override
    public Object getAsObject(FacesContext context,
            UIComponent component, String value) {
        Optional<Endereco> retorno = null;

        if (value != null && !"".equals(value)) {

            retorno = enderecoService.findById(new Long(value));

        }
        return retorno.orElse(null);
    }

    @Override
    public String getAsString(FacesContext context,
            UIComponent component, Object value) {
        if (value != null) {
            return Long.toString(((Endereco) value).getId());
        }
        return null;
    }

}
