

#Company

``` sql
INSERT INTO `coffeeprince`.`company` (`company_name`) VALUES ('스타벅스');
INSERT INTO `coffeeprince`.`company` (`company_name`) VALUES ('엔젤리너스');
INSERT INTO `coffeeprince`.`company` (`company_name`) VALUES ('커피빈');
INSERT INTO `coffeeprince`.`company` (`company_name`) VALUES ('할리스');
INSERT INTO `coffeeprince`.`company` (`company_name`) VALUES ('카페베네');
INSERT INTO `coffeeprince`.`company` (`company_name`) VALUES ('이디야');
```

#FrequencyEventList

``` sql
INSERT INTO `coffeeprince`.`frequency_event_list` (`company_id`, `event_name`, `start_date`, `end_date`) VALUES ('1', '2020 서머 e-프리퀀시', '2020-05-21 00:00:00', '2020-07-22 00:00:00');
```

#Frequency

``` sql
INSERT INTO `coffeeprince`.`frequency` (`event_id`, `frequency_name`) VALUES ('1', '미션');
INSERT INTO `coffeeprince`.`frequency` (`event_id`, `frequency_name`) VALUES ('1', '일반');`
```

#Tradeboard

``` sql
INSERT INTO `coffeeprince`.`tradeboard` (`created_date`, `modified_date`, `event_id`, `status`, `writer`) VALUES ('2020-07-11 00:00:00', '2020-07-11 00:00:00', '1', '0', 'mins99');
```

#FrequencyTadeList

``` sql
INSERT INTO `coffeeprince`.`frequency_trade_list` (`board_id`, `frequency_id`, `quantity`) VALUES ('1', '1', '3');
INSERT INTO `coffeeprince`.`frequency_trade_list` (`board_id`, `frequency_id`, `quantity`) VALUES ('1', '2', '6');
```




