create index IX_B0DA5D3E on se_money_Category (type);

create index IX_3BF1212B on se_money_Operation (category_id);

create index IX_6C9ECF73 on se_money_SubCategory (parent_category_id);