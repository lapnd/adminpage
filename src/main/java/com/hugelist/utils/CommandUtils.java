package com.hugelist.utils;

public class CommandUtils {
/*

drop keyspace "hugelist";
CREATE KEYSPACE "hugelist" WITH replication = {'class':'SimpleStrategy','replication_factor':1};
USE "hugelist";

 

CREATE TABLE account (
  id text,
  aid text,
  challengekey text,
  chataccount text,
  chatpass text,
  citiescityid text,
  citiescityidsec int,
  company text,
  companysec int,
  countryid text,
  countryidsec int,
  createdate text,
  createdatesec int,
  devicenotificationid set<text>,
  displayname text,
  displaynamesec int,
  email text,
  homephone text,
  homephonesec int,
  isactive boolean,
  isrecoverkey text,
  languageid text,
  languageidsec int,
  malegenre text,
  malegenresec int,
  mobilephone text,
  mobilephonesec int,
  officephone text, 
  officephonesec int, 
  pass text, 
  privatekey text, 
  publickey text, 
  regionid text, 
  regionidsec int, 
  sessionexpired timestamp, 
  timezoneid text, 
  timezoneidsec int, 
  token1 text, 
  username text, 
  usernamesec int, 
  PRIMARY KEY (id)
) ;

CREATE CUSTOM INDEX acc_username_index ON "account"(username) USING 'com.tuplejump.stargate.cas.PerColIndex';
CREATE CUSTOM INDEX acc_pwd_index ON "account"(pass) USING 'com.tuplejump.stargate.cas.PerColIndex';
CREATE CUSTOM INDEX acc_aid_index ON "account"(aid) USING 'com.tuplejump.stargate.cas.PerColIndex';
CREATE CUSTOM INDEX acc_company_index ON "account"(company) USING 'com.tuplejump.stargate.cas.PerColIndex';
CREATE CUSTOM INDEX acc_displayname_index ON "account"(displayname) USING 'com.tuplejump.stargate.cas.PerColIndex';
CREATE CUSTOM INDEX acc_email_index ON "account"(email) USING 'com.tuplejump.stargate.cas.PerColIndex';
CREATE CUSTOM INDEX acc_chataccount_index ON "account"(chataccount) USING 'com.tuplejump.stargate.cas.PerColIndex';


	 CREATE TABLE campaign (
	  campaignid text,
	  acceptofferstatus boolean,
	  accountaid text,
	  accountcreatename text,
	  price double,
	  currentreservationamount double,
	  currentdailyamount double,
	  bulkminimum text,
	  bulkstatus boolean,
	  bulktotal text,
	  campaigntypeid int,
	  campaigntypename text,
	  categorycampaignrefid text,
	  classgroupver int,
	  imagelocation set<text>,
	  classitemvalues set<text>,
	  closingtime text,
	  createdate text,
	  dailyamount double,
	  dailyamountmax double,
	  dailystatus boolean,
	  description text,
	  reservationamount double,
	  reservationamountmax double,
	  reservationstatus boolean,
	  timezone text,
	  title text,
	  totalcontact int,
	  viewcount int,
	  PRIMARY KEY(campaignid));
	
	CREATE CUSTOM INDEX cmp_aid_index ON "campaign"(accountaid) USING 'com.tuplejump.stargate.cas.PerColIndex';
	CREATE CUSTOM INDEX cmp_title_index ON "campaign"(title) USING 'com.tuplejump.stargate.cas.PerColIndex';	
	CREATE CUSTOM INDEX cmp_description_index ON "campaign"(description) USING 'com.tuplejump.stargate.cas.PerColIndex';
	CREATE CUSTOM INDEX cmp_categoryId_index ON "campaign"(categorycampaignrefid) USING 'com.tuplejump.stargate.cas.PerColIndex';

// Add more column if table existed 
// ALTER TABLE "campaign" ADD price double;
// ALTER TABLE "campaign" ADD currentReservationAmount double;
// ALTER TABLE "campaign" ADD currentDailyAmount double;
// ALTER TABLE "campaign" ADD accountcreatename text;
// ALTER TABLE "campaign" ADD imagelocation set<text>;

// Add for Search Price in Range(min:max)
ALTER TABLE "campaign" ADD enablesearch text
CREATE INDEX cmp_price_index ON "campaign"(price)
CREATE INDEX cmp_enablesearch_index ON "campaign"(enablesearch)
-------- 
// Don't run & don't remove
//CREATE CUSTOM INDEX cmp_enablesearch_index ON "campaign"(enablesearch) USING 'com.tuplejump.stargate.cas.PerColIndex';
//CREATE CUSTOM INDEX cmp_price_index ON "campaign"(price) USING 'com.tuplejump.stargate.cas.PerColIndex';
--------

 CREATE TABLE campaigntype (
  campaigntypeid int,
  campaigntypename text,
  PRIMARY KEY (campaigntypeid)
) ;

CREATE CUSTOM INDEX cmpt_name_index ON "campaigntype"(campaigntypename) USING 'com.tuplejump.stargate.cas.PerColIndex';


CREATE TABLE category (
  categoryid text,
  accountid text,
  accountname text,
  categoryname text,
  categoryattribute text,
  latestversion int,
  PRIMARY KEY (categoryid)
);

CREATE CUSTOM INDEX ca_aid_index ON "category"(accountid) USING 'com.tuplejump.stargate.cas.PerColIndex';
CREATE CUSTOM INDEX ca_name_index ON "category"(categoryname) USING 'com.tuplejump.stargate.cas.PerColIndex';
CREATE CUSTOM INDEX ca_accountname_index ON "category"(accountname) USING 'com.tuplejump.stargate.cas.PerColIndex';
CREATE CUSTOM INDEX ca_categoryattribute_index ON "category"(categoryattribute) USING 'com.tuplejump.stargate.cas.PerColIndex';



CREATE TABLE classification (
  classificationid text,
  classificationname text,
  classificationattribute text,
  categoryid text,
  PRIMARY KEY (classificationid)
);

CREATE CUSTOM INDEX cf_name_index ON "classification"(classificationname) USING 'com.tuplejump.stargate.cas.PerColIndex';
CREATE CUSTOM INDEX cf_classificationattribute_index ON "classification"(classificationattribute) USING 'com.tuplejump.stargate.cas.PerColIndex';
CREATE CUSTOM INDEX cf_categoryid_index ON "classification"(categoryid) USING 'com.tuplejump.stargate.cas.PerColIndex';


 CREATE TABLE classitem (
  classitemid text,
  classificationid text,
  classitemname text,
  itemtyperefid text,
  valueunit text,
  PRIMARY KEY (classitemid)
);
CREATE CUSTOM INDEX ci_name_index ON "classitem"(classitemname) USING 'com.tuplejump.stargate.cas.PerColIndex';
CREATE CUSTOM INDEX ci_crefid_index ON "classitem"(classificationid) USING 'com.tuplejump.stargate.cas.PerColIndex';
CREATE CUSTOM INDEX ci_irefid_index ON "classitem"(itemtyperefid) USING 'com.tuplejump.stargate.cas.PerColIndex';
CREATE CUSTOM INDEX ci_valueunit_index ON "classitem"(valueunit) USING 'com.tuplejump.stargate.cas.PerColIndex';


CREATE TABLE classitemvalue (
  classitemvalueid text,
  classitemrefid text,
  value text,
  PRIMARY KEY (classitemvalueid)
);


CREATE TABLE fileupload (
 fileid text,
 aid text,
 dataid text,
 filename text,
 location text,
 PRIMARY KEY (fileid)
 );
 
CREATE CUSTOM INDEX fu_aid_index ON "fileupload"(aid) USING 'com.tuplejump.stargate.cas.PerColIndex';
CREATE CUSTOM INDEX fu_did_index ON "fileupload"(dataid) USING 'com.tuplejump.stargate.cas.PerColIndex';
CREATE CUSTOM INDEX fu_filename_index ON "fileupload"(filename) USING 'com.tuplejump.stargate.cas.PerColIndex';
 
  CREATE TABLE itemtype (
  itemtypeid text,
  name text,
  PRIMARY KEY (itemtypeid)
);


CREATE TABLE transactionlog ( 
	transactionlogid text, 
	campaignid text,
	accountid text, 
	transactiontype text, 
	PRIMARY KEY (transactionlogid)
);
  
CREATE CUSTOM INDEX tl_cid_index ON "transactionlog"(campaignid) USING 'com.tuplejump.stargate.cas.PerColIndex';
CREATE CUSTOM INDEX tl_aid_index ON "transactionlog"(accountid) USING 'com.tuplejump.stargate.cas.PerColIndex';
CREATE CUSTOM INDEX tl_tt_index ON "transactionlog"(transactiontype) USING 'com.tuplejump.stargate.cas.PerColIndex';


CREATE TABLE message (
  id text,
  aid text,
  campaignid text,
  message text,
  createdate text,
  status boolean,
  device text,
  PRIMARY KEY (id)
);
CREATE CUSTOM INDEX m_aid_index ON "message"(aid) USING 'com.tuplejump.stargate.cas.PerColIndex';
CREATE CUSTOM INDEX m_cid_index ON "message"(campaignid) USING 'com.tuplejump.stargate.cas.PerColIndex';
CREATE CUSTOM INDEX m_message_index ON "message"(message) USING 'com.tuplejump.stargate.cas.PerColIndex';
CREATE CUSTOM INDEX m_device_index ON "message"(device) USING 'com.tuplejump.stargate.cas.PerColIndex';



Change your db script:

create column family userdelegate with comparator = UTF8Type and column_metadata=[{column_name:delg_msid, validation_class: UTF8Type, index_type:KEYS},{column_name:user_msid, validation_class: UTF8Type, index_type:KEYS}];

In order to get this working, secondary indexes must be enabled over join columns.

Nghien cuu tai lieu sau
https://github.com/impetus-opensource/Kundera/wiki/ElementCollection-of-Basic-Types
https://github.com/impetus-opensource/Kundera/wiki/Embedded-super-columns-in-Cassandra
https://github.com/impetus-opensource/Kundera/wiki/Embedded-super-columns-in-Cassandra
https://github.com/impetus-opensource/Kundera/wiki/Entity-to-Key-Value-store-mapping
https://github.com/impetus-opensource/Kundera/wiki/Data-Types-Examples
https://github.com/impetus-opensource/Kundera/wiki/Composite--and-Compound-key-in-Cassandra

*/
}
