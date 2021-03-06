/*
 * Copyright (C) 2014 Toshiaki Maki
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package am.ik.categolj2.domain.service.loginhistory;

import javax.inject.Inject;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import am.ik.categolj2.domain.model.LoginHistory;
import am.ik.categolj2.domain.repository.loginhistory.LoginHistoryRepository;

@Service
public class LoginHistoryServiceImpl implements LoginHistoryService {
    @Inject
    LoginHistoryRepository loginHistoryRepository;

    @Override
    @Transactional
    public void save(LoginHistory loginHistory) {
        loginHistoryRepository.save(loginHistory);
    }

    @Override
    public Page<LoginHistory> findPage(Pageable pageable) {
        return loginHistoryRepository.findPageOrderByLoginDateDesc(pageable);
    }
}
