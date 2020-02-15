ALTER TABLE "hostmapping"
DROP CONSTRAINT "hostmapping_user_id_fkey",
ADD FOREIGN KEY ("user_id") REFERENCES "customer" ("user_id") ON DELETE NO ACTION ON UPDATE NO ACTION