package org.guideme.guideme.model;

import java.time.LocalTime;
import java.util.ArrayList;

import org.guideme.guideme.settings.ComonFunctions;

public class Estim {
	private String id; //file name of the audio file
	private String startAt; //time to start audio at
	private String stopAt; //time to stop audio at
	private String target; //page to go to when the audio finishes
	private String set; //flags to set when the audio finishes
	private String unSet; //flags to unset when the audio finishes
	private String repeat; //number of times to repeat the audio
	private String ifSet; //only play the audio if theses flags are set
	private String ifNotSet; //don't play the audo if these flags are set
	private String jscript; //javascript function to run on audio finish
	private LocalTime ifBefore; //Time of day must be before this time
	private LocalTime ifAfter; //Time of day must be after this time
	private ComonFunctions comonFunctions = ComonFunctions.getComonFunctions();
	private String scriptVar;
	private String command;  //Command to send to the 2B
	

	public Estim(String id, String startAt, String stopAt, String target, String ifSet, String ifNotSet, String set, String unSet, String repeat, String jscript, String ifAfter, String ifBefore, String scriptVar, String command) {
		this.id = id;
		this.startAt = startAt;
		this.stopAt = stopAt;
		this.target = target;
		this.ifSet = ifSet;
		this.ifNotSet = ifNotSet;
		this.set = set;
		this.unSet = unSet;
		this.repeat = repeat;
		this.jscript = jscript;
		if (ifBefore.equals("")) {
			this.ifBefore = null;
		} else {
			this.ifBefore = LocalTime.parse(ifBefore);
		}
		if (ifAfter.equals("")) {
			this.ifAfter = null;
		} else {
			this.ifAfter = LocalTime.parse(ifAfter);
		}
		this.scriptVar = scriptVar;
		this.command = command;

	}

	public String getId() {
		return id;
	}

	public String getStartAt() {
		return startAt;
	}

	public String getStopAt() {
		return stopAt;
	}

	public String getTarget() {
		return target;
	}
	
	//pass the current flags and check if we can play this audio
	public boolean canShow(ArrayList<String> setList) {
		boolean retVal = comonFunctions.canShowTime(ifBefore, ifAfter);
		if (retVal) {
			retVal =  comonFunctions.canShow(setList, ifSet, ifNotSet);
		}
		return retVal;
	}

	//pass the current flags and do the set / unset on it
	public void setUnSet(ArrayList<String> setList) {
		comonFunctions.SetFlags(set, setList);
		comonFunctions.UnsetFlags(unSet, setList);
	}

	public String getRepeat() {
		return repeat;
	}

	public String getJscript() {
		return jscript;
	}

	public String getIfSet() {
		return ifSet;
	}

	public String getIfNotSet() {
		return ifNotSet;
	}

	public LocalTime getIfBefore() {
		return ifBefore;
	}

	public void setIfBefore(String ifBefore) {
		if (ifBefore.equals("")) {
			this.ifBefore = null;
		} else {
			this.ifBefore = LocalTime.parse(ifBefore);
		}
	}

	public LocalTime getIfAfter() {
		return ifAfter;
	}

	public void setIfAfter(String ifAfter) {
		if (ifAfter.equals("")) {
			this.ifAfter = null;
		} else {
			this.ifAfter = LocalTime.parse(ifAfter);
		}
	}

	
	public String getScriptVar() {
		return scriptVar;
	}

	public String getCommand() {
		return command;
	}

}
