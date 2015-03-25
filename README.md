## android-progress-textview
Set progress in a TextView.

#### Usage
From:

    <com.eftimoff.progresstextview.ProgressTextView
        android:textSize="33sp"
        android:text="////////////////////"
        android:gravity="center"
        app:ptv_progressColor="@android:color/white"
        android:textColor="#d684ad"
        android:id="@+id/progressBar1"
        android:layout_width="match_parent"
        android:layout_height="wrap_content" />
        
And some calls to:

    progressTextView1.setProgress(progressStatus);

To: 

## Attributes

|     attr    	        |  default  	|                         mean                         	|
|:-----------:	        |:---------:	|:----------------------------------------------------:	|
| ptv_progressColor   	|     #FFFFFF   |                  Color of the progress.        	    |
| ptv_progress 	        |       0 	    |                  The initial progress.         	    |
| ptv_max  	            |     100     	|                  The maximum progress.        	    |

## Contributors

I want to update this library and make it better. So any help will be appreciated.
Make and pull - request and we can discuss it.

## Download
Not yet
	dependencies {
		compile 'com.eftimoff:android-progress-textview:1.0.0@aar'
	}

## Licence

    Copyright 2015 Georgi Eftimov

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
