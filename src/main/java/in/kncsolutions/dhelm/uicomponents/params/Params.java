/**
*Copyright 2017 Pallav Nandi Chaudhuri@Knc Solutions Private Limited

*Licensed under the Apache License, Version 2.0 (the "License");
*you may not use this file except in compliance with the License.
*You may obtain a copy of the License at

* http://www.apache.org/licenses/LICENSE-2.0

*Unless required by applicable law or agreed to in writing, software
*distributed under the License is distributed on an "AS IS" BASIS,
*WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
*See the License for the specific language governing permissions and
*limitations under the License.
*/
package in.kncsolutions.dhelm.uicomponents.params;

/**
*
*/
public class Params{
    public static boolean isDemo=false;
    public static boolean isHavePwd=false;
	/**
	*@return the present state of the isDemo.
	*/
	public static boolean getIsDemo(){
	  return isDemo;
	}
	/**
	*@return the present state of the isHavePwd.
	*/
	public static boolean getIsHavePwd(){
	  return isHavePwd;
	}
	/**
	*@param state : isDemo can be set to either true or false
	*/
	public static void setIsDemo(boolean state){
	  isDemo=state;
	}
	/**
	*@param state : isHavePwd can be set to either true or false
	*/
	public static void setIsHavePwd(boolean state){
	  isHavePwd=state;
	}
}