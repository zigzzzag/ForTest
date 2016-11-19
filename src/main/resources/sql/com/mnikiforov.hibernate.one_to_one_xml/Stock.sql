CREATE TABLE stock_detail (
  id          INTEGER PRIMARY KEY    NOT NULL,
  comp_name   CHARACTER VARYING(100) NOT NULL,
  comp_desc   CHARACTER VARYING(255) NOT NULL,
  remark      CHARACTER VARYING(255) NOT NULL,
  listed_date DATE                   NOT NULL
);

CREATE TABLE stock (
  id             INTEGER PRIMARY KEY   NOT NULL,
  stockdetail_id INTEGER,
  stock_code     CHARACTER VARYING(10) NOT NULL,
  stock_name     CHARACTER VARYING(20) NOT NULL
);

ALTER TABLE stock
  ADD CONSTRAINT FK_STOCKDETAIL
FOREIGN KEY (stockdetail_id)
REFERENCES stock_detail
ON DELETE CASCADE;
