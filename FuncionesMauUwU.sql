use uwu;
set global log_bin_trust_function_creators = 1;

delimiter ;;

create procedure IniSes(id integer)
begin
update sesiones set ses_inicio = now() where (id = ses_id);
end;

create procedure doAction(id integer)
begin
update sesiones set ses_ult_act = now() where (sesiones.usr_id = id);
end;

create function LogIn(correo varchar(255), pass varchar(255), IP varchar(16))
returns bool
begin
if (correo in (usr_correo)) then 
	if (pass = (select usr_pass from usuarios where (correo = usr_correo))) then 
		set @conf = true;
        if (IP not in (select ses_ip from sesiones where (sesiones.usr_id = (select usr_id from usuarios where (usr_correo = correo))))) then
			select usr_id into @id from sesiones where (usr_correo = correo);
            insert into sesiones(ses_ip, ses_inicio, ses_fin, ses_ult_act, usr_id) values
            (IP, now(), null, now(), @id);
		else
			select ses_id from sesiones where();
			IniciSes(@Sid);
            doAction(@Sid);
		end if;
    else 
		set @conf = false; 
    end if;
else 
	set @conf = false;
end if;
return @conf;
end;;