/*
 *  Copyright 2016 http://www.hswebframework.org
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 *
 */

package org.hswebframework.web.authorization.oauth2.client.listener;


import java.util.Optional;
import java.util.function.Function;

/**
 * TODO 完成注释
 *
 * @author zhouhao
 */
public class OAuth2CodeAuthBeforeEvent implements OAuth2Event {
    private String                   code;
    private String                   state;
    private Function<String, Object> parameterGetter;

    public OAuth2CodeAuthBeforeEvent(String code, String state, Function<String, Object> parameterGetter) {
        this.code = code;
        this.state = state;
        this.parameterGetter = parameterGetter;
    }

    public String getCode() {
        return code;
    }

    public String getState() {
        return state;
    }

    @SuppressWarnings("unchecked")
    public <T> Optional<T> getParameter(String name) {
        return Optional.ofNullable((T) parameterGetter.apply(name));
    }

}
